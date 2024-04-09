fun main() {
    var heap : AmontoavelMaximo = ArvoreHeapMaximo(10)

    heap.inserir(4)
    heap.inserir(8)
    heap.inserir(2)
    heap.inserir(7)
    heap.atualizar(6)
    heap.inserir(1)

    println(heap.imprimir()) //[1, 2, 4, 8, 7]
    println(heap.extrair())
    println(heap.obter())
    println(heap.obter())
    println(heap.imprimir())
    
}