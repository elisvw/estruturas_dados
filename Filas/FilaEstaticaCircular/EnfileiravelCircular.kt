//DAO - Data Access Object 
interface EnfileiravelCircular {
    fun enfileirar(dado: Any?)
    fun desenfileirar(): Any?
    fun espiar(): Any?
    fun atualizar(novoDado: Any?) 
    //substitui o que tem na fila por algum dado
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
}