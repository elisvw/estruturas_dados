public interface Amontoavel {
    fun inserir(dado: Int) 
    fun extrair(): Int
    fun obter(): Int
    fun atualizar(dado: Int)
    fun imprimir(): String
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean

    //os outros métodos são privados
}