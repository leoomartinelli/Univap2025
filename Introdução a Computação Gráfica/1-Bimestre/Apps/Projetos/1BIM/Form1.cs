using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ProjetoWagner
{
    public partial class Form1 : Form
    {

        // Variáveis para armazenar os valores da reta
        private double m = 0;
        private double b = 0;
        private double xMin = -10;
        private double xMax = 10;

        // Lista para armazenar os pontos da reta
        private List<Tuple<float, float>> pontos = new List<Tuple<float, float>>();



        public Form1()
        {
            InitializeComponent();
        
            

        }

       

        private void Form1_Paint(object sender, PaintEventArgs e)
        {
            // Obter o objeto Graphics para desenhar no formulário
            Graphics g = e.Graphics;

            // Desenhar os eixos x e y
            Pen caneta = new Pen(Color.Black, 2);
            int centerX = Width / 2;
            int centerY = Height / 2;

            // Desenhar o eixo X
            g.DrawLine(caneta, 0, centerY, Width, centerY);

            // Desenhar o eixo Y
            g.DrawLine(caneta, centerX, 0, centerX, Height);

            // Desenhar a reta y = mx + b
            if (pontos.Count > 0)
            {
                Pen LinhaCaneta = new Pen(Color.Red, 2);
                Point[] pontosTela = new Point[pontos.Count];

                // Converter os pontos da lista para coordenadas da tela
                for (int i = 0; i < pontos.Count; i++)
                {
                    float x = pontos[i].Item1; // Coordenada x
                    float y = pontos[i].Item2; // Coordenada y

                    // Converter coordenadas cartesianas para coordenadas da tela
                    int screenX = centerX + (int)(x ); // Ajustar escala
                    int screenY = centerY - (int)(y ); // Inverter Y para o sistema de coordenadas da tela

                    pontosTela[i] = new Point(screenX, screenY);
                }

                // Desenhar a reta
                g.DrawLines(LinhaCaneta, pontosTela);
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            // Obter os valores de entrada
            m = double.Parse(txtA.Text);
            b = double.Parse(txtB.Text);
            xMin = double.Parse(txtXMin.Text);
            xMax = double.Parse(txtXMax.Text);

            // Calcular os pontos da reta e armazená-los na lista
            pontos.Clear(); // Limpar a lista antes de adicionar novos pontos
            for (double x = xMin; x <= xMax; x += 0.1) // Incremento de 0.1 para suavizar a reta
            {
                double y = m * x + b;
                pontos.Add(new Tuple<float, float>((float)x, (float)y)); // Armazenar (x, y) como Tuple
            }

            // Forçar a redesenhar o formulário
            Invalidate();


        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void Form1_SizeChanged(object sender, EventArgs e)
        {
            Invalidate();
        }

        
    }
}

