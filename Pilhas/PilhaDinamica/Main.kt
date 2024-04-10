//Igual o da estática

fun main(){
    var pilha: EmpilhavelDinamica = PilhaDinamica(7) 
    pilha.empilhar("Instituto")
    pilha.empilhar("Federal")
    println("Topo: ${pilha.espiar()}")
    pilha.empilhar("de")
    pilha.empilhar("Educação")
    pilha.empilhar("Ciência")
    val dadoQualquer = pilha.desempilhar()
    pilha.empilhar("e")
    pilha.empilhar("Tecnologia")
    pilha.empilhar(dadoQualquer)
    println("Dados: ${pilha.imprimir()}")
}