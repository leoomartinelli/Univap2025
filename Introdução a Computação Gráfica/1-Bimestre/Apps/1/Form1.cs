using System.Drawing;

/*Colegio Técnico Antônio Teixeira Fernandes (Univap)
 * Curso Técnico em Informática - Data de Entrega: 01 / 02 / 2025
 * Autores do Projeto:Leonardo Martinelli de Oliveira Lima
 *
 * Turma: 2M
 * Atividade Proposta em aula
 * Observação: < colocar se houver>
 * 
 * 
 * ******************************************************************/
using System.Windows.Forms;

namespace ProjetoPaint
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private int[] xs = new int[100]; // Array para coordenadas X
        private int[] ys = new int[100]; // Array para coordenadas Y
        private int[] rs = new int[100]; // Array para cor Vermelho
        private int[] gs = new int[100]; // Array para cor Verde
        private int[] bs = new int[100]; // Array para cor Azul
        private int contador = 0; // Quantidade de pontos armazenados
        public void Pintap(int x, int y, int r, int g, int b, PaintEventArgs e)
        {
            Color cor = Color.FromArgb(r, g, b);
            Pen caneta = new Pen(cor,0);
            e.Graphics.DrawLine(caneta, x , y , x + 1, y); // Desenha um círculo pequeno (ponto)
        }



        private void Form1_Paint(object sender, PaintEventArgs e)
        {
            for (int i = 0; i < contador; i++) // Percorre todos os pontos armazenados
            {
                Pintap(xs[i], ys[i], rs[i], gs[i], bs[i], e);
            }
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {
            {

            }
        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        public void label1_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            string[] coordenadas = textBox1.Text.Split('\n'); // Divide as linhas (coordenadas)
            string[] cores = textBox2.Text.Split('\n'); // Divide as linhas (cores)

            int numEntradas = coordenadas.Length; // Garante o mesmo número de coordenadas e cores

            for (int i = 0; i < numEntradas && contador < 100; i++)
            {
                string[] valores = coordenadas[i].Trim().Split(',');
                string[] valoresCor = cores[i].Trim().Split(',');

                if (valores.Length == 2 && valoresCor.Length == 3 &&
                    int.TryParse(valores[0], out int x) &&
                    int.TryParse(valores[1], out int y) &&
                    int.TryParse(valoresCor[0], out int r) &&
                    int.TryParse(valoresCor[1], out int g) &&
                    int.TryParse(valoresCor[2], out int b))
                {
                    xs[contador] = x;
                    ys[contador] = y;
                    rs[contador] = r;
                    gs[contador] = g;
                    bs[contador] = b;
                    contador++;

                    listBox1.Items.Add($"({x}, {y}) - RGB({r}, {g}, {b})"); // Adiciona à ListBox
                }
            }

            Refresh();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            

        }
    }
}
