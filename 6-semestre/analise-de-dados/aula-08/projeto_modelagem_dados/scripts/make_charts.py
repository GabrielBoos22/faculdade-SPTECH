
# coding: utf-8
import pandas as pd
from pathlib import Path
from matplotlib import pyplot as plt

client = "LATAM"

def main():
    base = Path(__file__).resolve().parents[1]
    processed = base / "processed"
    charts = base / "charts"
    charts.mkdir(exist_ok=True)

    comp_bucket = pd.read_csv(processed / "competitors_by_bucket.csv")
    pivot1 = comp_bucket.pivot(index="bucket", columns="airline", values="num_flights").fillna(0)
    fig = plt.figure()
    pivot1.plot(kind="bar")
    plt.title("Voos por intervalo de horário e companhia (últimos 6 meses)")
    plt.xlabel("Intervalo de horário")
    plt.ylabel("Número de voos")
    plt.xticks(rotation=0)
    plt.tight_layout()
    plt.savefig(charts / "voos_por_bucket.png")
    plt.close(fig)

    comp_only = pd.read_csv(processed / "competitors_availability_by_bucket.csv")
    fig = plt.figure()
    pivot2 = comp_only.pivot_table(index="bucket", columns="airline", values="seat_km", aggfunc="sum").fillna(0)
    pivot2.plot(kind="bar")
    plt.title("Concorrência: seat-km disponíveis por intervalo")
    plt.xlabel("Intervalo de horário")
    plt.ylabel("Seat-km disponíveis")
    plt.xticks(rotation=0)
    plt.tight_layout()
    plt.savefig(charts / "concorrencia_seat_km_por_bucket.png")
    plt.close(fig)

    share_bucket = pd.read_csv(processed / "market_share_by_bucket.csv")
    fig = plt.figure()
    share_bucket.set_index("bucket")["market_share_%"].plot(kind="bar")
    plt.title(f"LATAM: participação de mercado por intervalo (seat-km %)")
    plt.xlabel("Intervalo de horário")
    plt.ylabel("Participação (%)")
    plt.xticks(rotation=0)
    plt.tight_layout()
    plt.savefig(charts / "market_share_por_bucket.png")
    plt.close(fig)

    compl_summary = pd.read_csv(processed / "complaints_summary.csv")
    compl_pivot = compl_summary.groupby(["month","airline"], as_index=False)["total_complaints"].sum()
    fig = plt.figure()
    for a in compl_pivot["airline"].unique():
        sub = compl_pivot[compl_pivot["airline"]==a].set_index("month")["total_complaints"]
        sub.plot(kind="line", marker="o", label=a)
    plt.title("Reclamações por mês (total, domésticas)")
    plt.xlabel("Mês")
    plt.ylabel("Reclamações")
    plt.legend()
    plt.tight_layout()
    plt.savefig(charts / "reclamacoes_mes.png")
    plt.close(fig)

if __name__ == "__main__":
    main()
