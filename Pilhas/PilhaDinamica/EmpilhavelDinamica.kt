interface EmpilhavelDinamica {
    fun empilhar(dado: Any?)
    fun desempilhar(): Any?
    fun espiar(): Any?
    fun atualizar(novoDado: Any?)

    fun estaVazia(): Boolean
    fun estaCheia(): Boolean
    fun imprimir(): String
}