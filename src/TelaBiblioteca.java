import javax.swing.*;
import java.awt.*;

public class TelaBiblioteca extends JFrame {

    private JTextField txtCodigo;
    private JTextField txtTitulo;
    private JTextField txtAutor;
    private JTextField txtAno;

    private JTextArea areaLivros;

    private Biblioteca biblioteca;

    public TelaBiblioteca() {

        biblioteca = new Biblioteca();

        setTitle("Sistema Gerencial de Biblioteca");
        setSize(700,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(5,2,10,10));

        painel.add(new JLabel("Código"));
        txtCodigo = new JTextField();
        painel.add(txtCodigo);

        painel.add(new JLabel("Título"));
        txtTitulo = new JTextField();
        painel.add(txtTitulo);

        painel.add(new JLabel("Autor"));
        txtAutor = new JTextField();
        painel.add(txtAutor);

        painel.add(new JLabel("Ano"));
        txtAno = new JTextField();
        painel.add(txtAno);

        JButton btnCadastrar = new JButton("Cadastrar Livro");
        JButton btnListar = new JButton("Listar Livros");

        painel.add(btnCadastrar);
        painel.add(btnListar);

        areaLivros = new JTextArea();

        JScrollPane scroll = new JScrollPane(areaLivros);

        add(painel, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        btnCadastrar.addActionListener(e -> cadastrarLivro());

        btnListar.addActionListener(e -> listarLivros());
    }

    private void cadastrarLivro() {

        int codigo = Integer.parseInt(txtCodigo.getText());
        String titulo = txtTitulo.getText();
        String autor = txtAutor.getText();
        int ano = Integer.parseInt(txtAno.getText());

        Livro livro = new Livro(
                codigo,
                titulo,
                autor,
                ano
        );

        biblioteca.adicionarLivro(livro);

        JOptionPane.showMessageDialog(
                this,
                "Livro cadastrado com sucesso!"
        );

        limparCampos();
    }

    private void listarLivros() {

        areaLivros.setText("");

        for (Livro livro : biblioteca.getLivros()) {
            areaLivros.append(livro + "\n");
        }
    }

    private void limparCampos() {
        txtCodigo.setText("");
        txtTitulo.setText("");
        txtAutor.setText("");
        txtAno.setText("");
    }
}