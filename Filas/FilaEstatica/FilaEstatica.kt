class FilaEstatica(val tamanho: Int = 10) : Enfileiravel { 
    //com o construtor já implementado na classe 
    //não pode omitir o tipo no construtor, apenas nas variáveis

    //variaveis de instancia 
    //já tem o tipo implícito
    private var ponteiroInicio = 0
    private var ponteiroFim = -1
    private var dados: Array<Any?> = arrayOfNulls(tamanho) 
    // a fila é vazia quando o inicio estiver depois do fim, e se inicio e fim estiver apontando pro mesmo elemento, só tem um elemento na fila

    //metodos auxiliares
    override fun estaCheia(): Boolean{
        return (ponteiroFim == dados.size - 1)
    }

    override fun estaVazia(): Boolean {
        return (ponteiroInicio == ponteiroFim + 1)
    }

    //LIFO - pilha
    //FIFO - fila
    override fun imprimir(): String {
        var resultado = "["
        for (i in ponteiroInicio..ponteiroFim){
            if (i == ponteiroFim)
            resultado += "${dados[i]}" 
            else 
            resultado += "${dados[i]}," 
        }
        return "$resultado]"
    }

    //metodos principais
    override fun espiar(): Any? { //retorna o dados do incio
        var dado: Any? = null
        if(!estaVazia()) {
            dado = dados[ponteiroInicio]
        } else {
            println("Queue is empty")
        }
        return dado
    }

    override fun desenfileirar(): Any? {
        var dado: Any? = null
        if(!estaVazia()) {
            dado = dados[ponteiroInicio]
            ponteiroInicio++ //para que o inicio seja o novo elemento
        } else {
            println("Queue is empty")
        }
        return dado
    }

    override fun enfileirar(dado: Any?) { //enfileira pelo fim
        if (!estaCheia()){
            ponteiroFim++
            dados[ponteiroFim] = dado
        } else {
            println("Queue is full")
        }
    }

    override fun atualizar(novoDado: Any?){
        if (!estaVazia()){
            dados[ponteiroInicio] = novoDado
        } else {
            println("Can't update")
        }
    }
}