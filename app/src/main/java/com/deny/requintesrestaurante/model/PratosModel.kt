package com.deny.requintesrestaurante.model

class PratosModel(
    var imagem: Int = 0,
    var nome: String = "",
    var quantidade: String = ""
) {
    fun toMap() : HashMap<String, Any> {

        var result : HashMap<String, Any> = HashMap<String, Any>()
        result.put("imagem", this.imagem)
        result.put("nome", this.nome)
        result.put("quantidade", this.quantidade)

        return result
    }
}