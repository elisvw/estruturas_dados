//igual a estatica
interface EnfileiravelDinamica {
    fun enfileirar(dado: Any?)
    fun desenfileirar(): Any?
    fun frente(): Any?
    fun atualizar(novoDado: Any?) 
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
}