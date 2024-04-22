data class DeQueNoDuplo (var dado: Any? = null) {
    // A classe data cria internamente os gets e sets
        var anterior: DeQueNoDuplo? = null
        var proximo: DeQueNoDuplo? = null
}