interface Arbonizavel{
    fun getRaiz(): NoTriplo
    fun inserir(dado: Any?)
    fun apagar(dado: Any?): Boolean
    fun remover(dado: Any?)
    fun removeSemFilhos(no: NoTriplo)
    fun removeUnicoFilho(no: NoTriplo)
    fun imprimirPreOrdem(): String
    fun imprimirEmOrdem(): String
    fun imprimirPosOrdem(): String
}