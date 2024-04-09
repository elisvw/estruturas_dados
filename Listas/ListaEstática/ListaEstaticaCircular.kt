/* como a lista se comporta: 
*0 preto
*1 branco
*2 azul
*inserir (0, amarelo) - insere no começo da lista
*0 amarelo
*1 preto
*2 branco
*3 azul */ 
// anexar - adiciona elemento no final da lista (igual ao enfileirar)
// estaCheia, estaVazia = idêntico ao da fila  
// selecionar = retorna o dado que foi chamado - indice valido: maior iqual a zero e menor que quantidade
// a posição fisica é igual a posição mais o ponteiro início % dados.size (por causa da estrutura circular) 
// atualizar = pega o dado passado como parâmetro e substitui - parecido com o selecionar 

class ListaEstaticaCircular(val tamanho: Int = 10) : Listavel {
 
	private var dados: Array<Any?> = arrayOfNulls(tamanho)
	private var quantidade = 0
	private var ponteiroInicio = 0
	private var ponteiroFim = -1

	//idêntico ao enfileirar de FilaEstaticaCircular
	override fun anexar(dado: Any?) {
		if (!estaCheia()) {
			ponteiroFim++
			if (ponteiroFim == dados.size)
				ponteiroFim = 0
			
			dados[ponteiroFim] = dado
			quantidade++
		} else {
			println("Lista cheia!")
		}
	}

	override fun selecionarTodos(): Array<Any?> {        
		var dadosAux: Array<Any?> = arrayOfNulls(quantidade)
		if (!estaVazia()) {
			var ponteiroAux = ponteiroInicio
			for (i in 0 until quantidade)
				dadosAux[i] = dados[(ponteiroAux+i)%dados.size]
            
        }
        return dadosAux
	}

	override fun selecionar (posicao: Int): Any? {
		var dadoAux: Any? = null
		if (!estaVazia()) {
			if (posicao >= 0 && 
					posicao < quantidade) {
				var posicaoFisica = (ponteiroInicio + posicao) % dados.size
				dadoAux = dados[posicaoFisica]
			} else {
				println("Indice Inválido!")	
			}
		} else {
			println("Lista Vazia!")		
		}
		return dadoAux
	}

	override fun atualizar (posicao: Int, dado: Any?) {
		if (!estaVazia()) {
			if (posicao >= 0 && 
					posicao < quantidade) {
				var posicaoFisica = 
					(ponteiroInicio + posicao) % dados.size
				dados[posicaoFisica] = dado
			} else {
				println("Indice Inválido!")	
			}
		} else {
			println("Lista Vazia!")		
		}
	}

	override fun estaCheia(): Boolean {
		return quantidade == dados.size
	}
	
	override fun estaVazia(): Boolean {
		return quantidade == 0
	}
	
	override fun imprimir(): String {
		var resultado = "["
		var ponteiroAux = ponteiroInicio
		for (i in 0 until quantidade) {
			resultado += if (i == ponteiroFim)
				"${dados[(ponteiroAux+i) % dados.size]}"
			else
				"${dados[(ponteiroAux+i) % dados.size]}, "			
		}
		return "$resultado]"
	}

	override fun apagar(posicao: Int): Any? {
		var dadoAux: Any? = null
		if (!estaVazia()) {
			if (posicao >= 0 && 
					posicao < quantidade) {
				var posicaoFisica = 
				(ponteiroInicio + posicao) % dados.size
				dadoAux = dados[posicaoFisica]
				var ponteiroAux = posicaoFisica
				for (i in posicao until (quantidade-1)) {
					var atual = ponteiroAux
					var proximo = (ponteiroAux+1)%dados.size

					dados[atual] = dados[proximo]
					ponteiroAux++
				}
				ponteiroFim--
				if (ponteiroFim == -1) 
					ponteiroFim = dados.size - 1
				
				quantidade--
			} else {
				println("Indice Inválido!")
			}
		} else {
			println("Lista Vazia!")
		}
		return dadoAux
	}

    override fun inserir(posicao: Int, dado: Any?) { 
		if (!estaCheia()) {
			if (posicao >= && posicao <= quantidade) {
				var posicaoFisica = (posicao + ponteiroInicio) % dados.size
				var atual = ponteiroFim + 1 
				for (i in 0 .. quantidade - posicao) {
				var anterior = atual - 1
				if (anterior == -1) {
					anterior = dados.size-1
				}
				dados[atual] = dados[anterior]
				atual--
				if (atual == -1) {
					atual = dados.size - 1 
				}
				}
				dados[posicaoFisica] = dado
				quantidade++
				ponteiroFim++ 
				if (ponteiroFim == dados.size) {
					ponteiroFim = 0
				}
			} else {
				println("Posição inválida")
			}
		} else {
			println("List is full")
		}
	}
}