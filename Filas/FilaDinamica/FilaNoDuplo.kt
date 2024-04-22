data class FilaNoDuplo (var dado: Any? = null) {
    // A classe data cria internamente os gets e sets
        var anterior: FilaNoDuplo? = null
        var proximo: FilaNoDuplo? = null
}