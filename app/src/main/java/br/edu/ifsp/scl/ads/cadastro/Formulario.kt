package br.edu.ifsp.scl.ads.cadastro

data class Formulario(
    val nomeCompleto: String,
    val telefone: String,
    val email: String,
    val sexo: String,
    val cidade: String,
    val uf: String,
    val uf1: String
) {
    override fun toString(): String {
        return "Nome Completo: $nomeCompleto\n" +
                "Telefone: $telefone\n" +
                "E-mail: $email\n" +
                "Sexo: $sexo\n" +
                "Cidade: $cidade\n" +
                "UF: $uf"
    }

}