package br.edu.ifsp.scl.ads.cadastro

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var nomeCompleto: EditText
    private lateinit var telefone: EditText
    private lateinit var email: EditText
    private lateinit var listaEmails: CheckBox
    private lateinit var sexoMasculino: RadioButton
    private lateinit var sexoFeminino: RadioButton
    private lateinit var cidade: EditText
    private lateinit var ufS: Spinner
    private lateinit var limparBt: Button
    private lateinit var salvarBt: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializando as views
        nomeCompleto = findViewById(R.id.nomecompleto)
        telefone = findViewById(R.id.telefoneEt)
        email = findViewById(R.id.emailEt)
        listaEmails = findViewById(R.id.listaEmailsCb)
        sexoMasculino = findViewById(R.id.masculinoRb)
        sexoFeminino = findViewById(R.id.femininoRb)
        cidade = findViewById(R.id.cidadeEt)
        ufS = findViewById(R.id.ufS)
        limparBt = findViewById(R.id.limparBt)
        salvarBt = findViewById(R.id.salvarBt)

        // Definindo o checkbox marcado
        // sexoMasculino.isChecked = true

        // Spinner de UF
        val estados = arrayOf("Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão",
            "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte",
            "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, estados)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        ufS.adapter = adapter

        // Ação do botão Limpar
        limparBt.setOnClickListener {
            nomeCompleto.text.clear()
            telefone.text.clear()
            email.text.clear()
            listaEmails.isChecked = false
            sexoMasculino.isChecked = false
            sexoFeminino.isChecked = false
            cidade.text.clear()
            ufS.setSelection(0)  // Reseta o Spinner para o primeiro item
        }

        // Ação do botão Salvar
        salvarBt.setOnClickListener {
            val nome = nomeCompleto.text.toString()
            val tel = telefone.text.toString()
            val emailText = email.text.toString()
            val isListaEmails = listaEmails.isChecked
            val sexo = if (sexoMasculino.isChecked) "Masculino" else if (sexoFeminino.isChecked) "Feminino" else "Não informado"
            val cidadeText = cidade.text.toString()
            val uf = ufS.selectedItem.toString()

            // Criando o objeto Formulário
            val formulario = Formulario(nome, tel, emailText, isListaEmails.toString(), sexo, cidadeText, uf)

            // Mostrando os valores no Toast
            Toast.makeText(this, formulario.toString(), Toast.LENGTH_LONG).show()
        }
    }
}