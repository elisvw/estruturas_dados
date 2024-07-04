interface ListavelHash {
    fun anexar(dado: Any?)
    fun selecionarTodos(): Array<Any?>
    fun selecionar(posicao: Int): Any?
    fun atualizar(posicao: Int, dado: Any?)
    fun apagar(posicao: Int): Any?
    fun apagarTodos(): Array<Any?>
    fun inserir(posicao: Int, dado: Any?)
    fun limpar()
    fun tamanho(): Int
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
}