
namespace Lab2
{
    public partial class Form1 : Form
    {
        public int xn, yn, xk, yk; // ����� �������
        Bitmap myBitmap; // ������ Bitmap ��� ������ �������
        Color currentBorderColor; // ������� ���� ������� � ������� ���� �������
        private int currentPenWidth = 1; // ������� ������� ����
        

        public Form1()
        {
            InitializeComponent();
        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }

        private void CDA(int xStart, int yStart, int xEnd, int yEnd)
        {
            int index, numberNodes;
            double xOutput, yOutput, dx, dy;

            xn = xStart;
            yn = yStart;
            xk = xEnd;
            yk = yEnd;
            dx = xk - xn;
            dy = yk - yn;
            numberNodes = 200;
            xOutput = xn;
            yOutput = yn;
            for (index = 1; index <= numberNodes; index++)
            {
                myBitmap.SetPixel((int)xOutput, (int)yOutput, currentBorderColor);
                xOutput = xOutput + dx / numberNodes;
                yOutput = yOutput + dy / numberNodes;
            }
        }





        private void FloodFill(int x1, int y1)
        {
            Color oldPixelColor = myBitmap.GetPixel(x1, y1);
            if ((oldPixelColor.ToArgb() != currentBorderColor.ToArgb())
            && (oldPixelColor.ToArgb() != Color.Green.ToArgb()))
            {
                myBitmap.SetPixel(x1, y1, Color.Green);
                FloodFill(x1 + 1, y1);
                FloodFill(x1 - 1, y1);
                FloodFill(x1, y1 + 1);
                FloodFill(x1, y1 - 1);
            }
            else
            {
                return;
            }
        }

        private void pictureBox1_MouseDown_1(object sender, MouseEventArgs e)
        {
            if (radioButton1.Checked == true)
            {
                xn = e.X;
                yn = e.Y;
            }
            else
            {
                MessageBox.Show("�� �� ������� �������� ������ ������!");
            }
        }

        private void pictureBox1_MouseUp_1(object sender, MouseEventArgs e)
        {
            Point start = new Point(xn, yn);
            Point end = new Point(e.X, e.Y);
            

            // ������ ����� �� PictureBox
            using (Graphics g = Graphics.FromHwnd(pictureBox1.Handle))
            {
                Pen myPen = new Pen(Color.Red, currentPenWidth);
                g.DrawLine(myPen, start, end);
            }

            // ��������� ���������� ��������� ����� ��� ��������� �����
            xn = e.X;
            yn = e.Y;
        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            Bitmap myBitmap = new Bitmap(pictureBox1.Height, pictureBox1.Width);
            Color newPixelColor = Color.FromArgb(247, 249, 239);

            for (int x = 0; x < myBitmap.Width; x++)
            {
                for (int y = 0; y < myBitmap.Height; y++)
                {
                    myBitmap.SetPixel(x, y, newPixelColor);
                }
            }

            pictureBox1.Image = myBitmap;

        }

        private void button2_Click_1(object sender, EventArgs e)
        {
            button1.Enabled = false;
            button2.Enabled = false;

            myBitmap = new Bitmap(pictureBox1.Width, pictureBox1.Height);
            using (Graphics g = Graphics.FromHwnd(pictureBox1.Handle))
            {
                if (radioButton1.Checked == true)
                {
                    CDA(10, 10, 10, 110);
                    CDA(10, 10, 110, 10);
                    CDA(10, 110, 110, 110);
                    CDA(110, 10, 110, 110);

                    CDA(150, 10, 150, 200);
                    CDA(250, 50, 150, 200);
                    CDA(150, 10, 250, 150);
                }

                else
                {
                    if (radioButton2.Checked == true)
                    {
                        myBitmap = pictureBox1.Image as Bitmap;
                        xn = 160;
                        yn = 40;
                        FloodFill(xn, yn);
                    }
                }
                pictureBox1.Image = myBitmap;
                pictureBox1.Refresh();
                button1.Enabled = true;
                button2.Enabled = true;
            }
        }

        private void button3_Click_1(object sender, EventArgs e)
        {
            DialogResult dialogResult = colorDialog1.ShowDialog();

            if (dialogResult == DialogResult.OK && radioButton1.Checked)
            {
                currentBorderColor = colorDialog1.Color;
            }
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void button4_Click(object sender, EventArgs e)
        {
            // ���������, ������� �� ������������� �������� �������� � �����
            if (int.TryParse(textBox1.Text, out int penWidth))
            {
                // ���������, ����� ������� ���� ���� � �������� ��������
                if (penWidth > 0 && penWidth <= 200) // ��������� ������� ���� �� 20
                {
                    // ������������� ����� ������� ����
                    currentPenWidth = penWidth;

                    // ���������� MessageBox � ��������������
                    MessageBox.Show($"������� ����� �������� �� {penWidth}.",
                                    "�����",
                                    MessageBoxButtons.OK,
                                    MessageBoxIcon.Information);
                }
                else
                {
                    // ���������� MessageBox � �������, ���� ������� ���� ��� ����������� ���������
                    MessageBox.Show("������� ����� ������ ���� �� 1 �� 200.",
                                    "������",
                                    MessageBoxButtons.OK,
                                    MessageBoxIcon.Error);
                }
            }
            else
            {
                // ���������� MessageBox � �������, ���� ������� ������������ ��������
                MessageBox.Show("������� ���������� �����!",
                                "������",
                                MessageBoxButtons.OK,
                                MessageBoxIcon.Error);
            }
        }

        private void button5_Click(object sender, EventArgs e)
        {
            
        }

        private void button6_Click(object sender, EventArgs e)
        {

        }
    }
}
