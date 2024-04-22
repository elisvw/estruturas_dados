interface ListavelDinamica {
    fun anexar(dado: Any?)
    fun selecionarTodos(): Array<Any?>
    fun selecionar(posicao: Int): Any?
    fun atualizar(posicao: Int, dado: Any?)
    fun apagar(posicao: Int): Any?
    fun inserir(posicao: Int, dado: Any?)
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
}