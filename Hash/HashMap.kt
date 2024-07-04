/* 
Hash = Conjunto aleatório de caracteres [a...z], [A...Z], [0...9]
Resumo do dado/uma mensagem
Utiliza a lista dinâmica p/ manipular dados armazenados em containers
*/
class HashMap(private val tamanhoTabela: Int = 10): Hashable {

    private var tabelaHash: Array<ListavelHash> = Array(tamanhoTabela) { ListaDinamicaHash() }
    private var quantidade = 0

    private fun funcaoEspalhamento(chave: Int): Int {
        val chaveString = chave.toString()
        val letraInicial = chaveString.lowercase()[0] 
        return letraInicial.code % tamanhoTabela //valor entre 0 e 25
    }

    private fun funcaoEspalhamento2(chave: Any): Int {
        val chaveString = chave.toString()
        var total = 0
        for (i in 0 until chaveString.length) {
            val letra = chaveString.lowercase()[i]
            total += letra.code
        }
        return total % tamanhoTabela
    }

    override fun adicionar(mapa: Mapa) { 
        val indice = funcaoEspalhamento2(mapa.chave)
        val listaTemp = tabelaHash[indice]
        if (contemChave(mapa.chave)) {
            for (i in 0 until listaTemp.tamanho()) {
                val elemento = listaTemp.selecionar(i) as Mapa
                val chaveLista = elemento.chave

                if (chaveLista == mapa.chave) {
                    listaTemp.atualizar(i, mapa)
                    break
                }
            }
        } else {
            listaTemp.anexar(mapa)
            quantidade++
        }
    }

    override fun remover(chave: Any): Any? { 
        var dadoAux: Any? = null
        if (!estaVazia()) {
            if (contemChave(chave)) {
                val indice = funcaoEspalhamento2(chave)
                val listaTemp = tabelaHash[indice]

                for (i in 0 until listaTemp.tamanho()) {
                    val elemento = listaTemp.selecionar(i) as Mapa
                    val chaveLista = elemento.chave

                    if (chave == chaveLista) {
                        dadoAux = elemento.dado
                        listaTemp.apagar(i)
                        quantidade--
                    }
                }
            } else {
                println("Chave não existente.")
            }
        } else {
            println("A estrutura está vazia!")
        }
        return dadoAux
    }

    override fun contemChave(chave: Any): Boolean { 
        var chaveEncontrada = false 
        if (!estaVazia()) {
            val indice = funcaoEspalhamento2(chave)
            val listaTemp = tabelaHash[indice]

            for (i in 0 until listaTemp.tamanho()) {
                val elemento = listaTemp.selecionar(i) as Mapa
                val chaveLista = elemento.chave
                
                if (chave == chaveLista) {
                    chaveEncontrada = true
                    break
                }
            }
        } else {
            println("A estrutura está vazia!")
        }
        return chaveEncontrada
    }

    override fun buscar(chave: Any): Any? { 
        var dadoAux: Any? = null
        if (!estaVazia()) {
            if (contemChave(chave)) {
                val indice = funcaoEspalhamento2(chave)
                val listaTemp = tabelaHash[indice]

                for (i in 0 until listaTemp.tamanho()) {
                    val elemento = listaTemp.selecionar(i) as Mapa
                    val chaveLista = elemento.chave

                    if (chave == chaveLista) {
                        dadoAux = elemento.dado
                        break
                    }
                }
            } else {
                println("Chave não encontrada.")
            }
        } else {
            println("A estrutura está vazia1")
        }
        return dadoAux
    }

    override fun tamanho(): Int { 
        return quantidade
    }

    override fun estaVazia(): Boolean { 
        return (quantidade == 0)
    }

    override fun imprimir(): String { 
        var resultado = "["
		for (i in 0 until tabelaHash.size) {
			val listaTemp = tabelaHash[i] 
			resultado += listaTemp.imprimir()
		}
		return "$resultado]"
    }
}