package org.example

class GerenciadorMusica {
    var musicas = mutableMapOf<Int, Musica>()
    var lastInsertedId: Int? = null
    fun adicionarItem() {
        println("Digite o ID da música:")
        val id = readLine()?.toIntOrNull() ?: return println("ID inválido!")

        println("Digite o título da música:")
        val titulo = readLine() ?: return println("Título inválido!")

        println("Digite a duração da música (em minutos):")
        val duracao = readLine()?.toDoubleOrNull() ?: return println("Duração inválida!")

        println("Digite a classificação da música (1 a 5):")
        val classificacao = readLine()?.toIntOrNull() ?: return println("Classificação inválida!")

        println("Digite o nome do artista:")
        val artista = readLine() ?: return println("Artista inválido!")

        println("Digite o gênero musical:")
        val genero = readLine() ?: return println("Gênero inválido!")

        val musica = Musica(id, titulo, duracao, classificacao, artista, genero)
        musicas[id] = musica
        lastInsertedId = id

        println("Música adicionada com sucesso!")
    }

    fun removerItem() {
        println("Digite o ID da música que deseja remover:")
        val id = readLine()?.toIntOrNull() ?: return println("ID inválido!")

        if (musicas.remove(id) != null) {
            println("Música removida com sucesso!")
        } else {
            println("ID não encontrado.")
        }
    }

    fun removerUltimoItem() {
        if (lastInsertedId != null && musicas.remove(lastInsertedId) != null) {
            println("Última música inserida foi removida.")
        } else {
            println("Nenhuma música para remover.")
        }
    }

    fun exibirItens() {
        if (musicas.isEmpty()) {
            println("Nenhuma música cadastrada.")
            return
        }

        for ((id, musica) in musicas) {
            println("ID: $id | Título: ${musica.titulo}, Artista: ${musica.artista}, Gênero: ${musica.genero}, Duração: ${musica.duracao}, Classificação: ${musica.classificacao}")
        }
    }

    fun buscarItem() {
        println("Digite o ID da música que deseja buscar:")
        val id = readLine()?.toIntOrNull() ?: return println("ID inválido!")

        val musica = musicas[id]
        if (musica != null) {
            println("Música encontrada: Título: ${musica.titulo}, Artista: ${musica.artista}, Gênero: ${musica.genero}, Duração: ${musica.duracao}, Classificação: ${musica.classificacao}")
        } else {
            println("Chave não encontrada.")
        }
    }

    fun atualizarItem() {
        println("Digite o ID da música que deseja atualizar:")
        val id = readLine()?.toIntOrNull() ?: return println("ID inválido!")

        var musica = musicas[id]
        if (musica != null) {
            println("Digite o novo título da música (ou pressione ENTER para manter o valor atual):")
            val novoTitulo = readLine()
            if (!novoTitulo.isNullOrBlank()) {
                musica.titulo = novoTitulo
            }

            println("Digite a nova duração da música (ou pressione ENTER para manter o valor atual):")
            val novaDuracao = readLine()?.toDoubleOrNull()
            if (novaDuracao != null) {
                musica.duracao = novaDuracao
            }

            println("Música atualizada com sucesso!")
        } else {
            println("ID não encontrado.")
        }
    }

    fun gerarRelatorio() {
        if (musicas.isEmpty()) {
            println("Nenhuma música cadastrada para gerar relatório.")
            return
        }

        val somaDuracoes = musicas.values.sumOf { it.duracao }
        val mediaDuracao = somaDuracoes / musicas.size

        println("Relatório:")
        println("Soma total das durações: $somaDuracoes minutos")
        println("Média de duração das músicas: $mediaDuracao minutos")
    }
}