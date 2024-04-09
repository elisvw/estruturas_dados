public interface AmontoavelMaximo {
    fun inserir(dado: Int) 
    fun extrair(): Int
    fun obter(): Int
    fun atualizar(dado: Int)
    fun imprimir(): String
    fun estaCheia(): Boolean
    fun estaVazia(): Boolean
}