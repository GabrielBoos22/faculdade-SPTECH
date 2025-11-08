
# coding: utf-8
"""
Pipeline de análise SP->RJ (últimos 6 meses)
Como usar:
1) Coloque seus CSVs em raw/ com os nomes:
   - flights_sp_rj.csv
   - complaints_domestic.csv
2) Rode: python run_analysis.py
3) Resultados em processed/ e charts/
"""
import pandas as pd
from pathlib import Path
import numpy as np

client = "LATAM"
distance_km = 360

def time_bucket_from_str(t):
    h = int(t.split(':')[0])
    if 6 <= h < 10:
        return "06:00-10:00"
    elif 10 <= h < 12:
        return "10:00-12:00"
    elif 12 <= h < 16:
        return "12:00-16:00"
    elif 16 <= h < 20:
        return "16:00-20:00"
    else:
        return "20:00-06:00"

def main():
    base = Path(__file__).resolve().parents[1]
    raw = base / "raw"
    processed = base / "processed"
    processed.mkdir(exist_ok=True)

    flights = pd.read_csv(raw / "flights_sp_rj.csv", parse_dates=["date"])
    if "bucket" not in flights.columns:
        flights["bucket"] = pd.to_datetime(flights["dep_time"], format="%H:%M:%S", errors="coerce").dt.strftime("%H:%M:%S")
        flights["bucket"] = flights["bucket"].fillna("00:00:00").apply(lambda x: time_bucket_from_str(x))

    flights["seat_km"] = flights["seats_available"] * flights["distance_km"]
    competitors_by_bucket = (flights.groupby(["bucket","airline"]).size()
                             .reset_index(name="num_flights"))
    competitors_by_bucket.to_csv(processed / "competitors_by_bucket.csv", index=False)

    avail_by_bucket = (flights.groupby(["bucket","airline"], as_index=False)
                       .agg(seats_available=("seats_available","sum"),
                            seat_km=("seat_km","sum"),
                            flights=("flight_no","count")))
    avail_by_bucket[avail_by_bucket["airline"] != client]\
        .to_csv(processed / "competitors_availability_by_bucket.csv", index=False)

    share = avail_by_bucket.copy()
    share["is_client"] = share["airline"].eq(client)
    def share_calc(g):
        client_seat_km = g.loc[g["is_client"], "seat_km"].sum()
        total = g["seat_km"].sum()
        return pd.Series({"client_seat_km": client_seat_km, "total_seat_km": total})
    share_bucket = (share.groupby("bucket").apply(share_calc).reset_index())
    share_bucket["market_share_%"] = (share_bucket["client_seat_km"] / share_bucket["total_seat_km"] * 100).round(2)
    share_bucket.to_csv(processed / "market_share_by_bucket.csv", index=False)

    complaints = pd.read_csv(raw / "complaints_domestic.csv")
    compl_summary = (complaints.groupby(["month","origin_city","complaint_group","airline"], as_index=False)
                     .agg(total_complaints=("count","sum")))
    compl_summary.to_csv(processed / "complaints_summary.csv", index=False)

if __name__ == "__main__":
    main()
