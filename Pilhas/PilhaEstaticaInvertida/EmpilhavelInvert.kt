interface EmpilhavelInvert {
    //Métodos principais
    fun empilhar(dado: Any?)
    fun desempilhar(): Any?
    fun topo(): Any?

    //Métodos auxiliares
    fun estaVazia(): Boolean
    fun estaCheia(): Boolean
    fun imprimir(): String
}