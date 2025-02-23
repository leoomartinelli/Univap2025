namespace ProjetoPaint
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        public void Pintap(int x, int y, int r, int g, int b, PaintEventArgs e)
        {        
        Color cor = new Color();    
        cor = Color.FromArgb(255,0,0);
        Pen caneta = new Pen(cor, 0);
        e.Graphics.DrawLine(caneta, x, y, x + 1, y);
        }

       

        private void Form1_Paint(object sender, PaintEventArgs e)
        {
            Pintap(100, 100, 255, 0, 0, e);  
        }
    }
}
