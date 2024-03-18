interface DuplamenteEnfileiravel {
    fun enfileirarInicio(dado: Any?)
    fun enfileirarFim(dado: Any?) 
    fun desenfileirarInicio(): Any?
    fun desenfileirarFim(): Any?
    fun espiarFrente(): Any?
    fun espiarTras(): Any?
    fun atualizarInicio(novoDado: Any?)
    fun atualizarFim(novoDado: Any?)
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
    fun imprimir(): String
}