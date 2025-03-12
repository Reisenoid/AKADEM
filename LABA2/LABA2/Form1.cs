namespace LABA2
{
    public partial class Form1 : Form
    {
        public int xn, yn, xk, yk; // концы отрезка
        Bitmap myBitmap; // объект Bitmap для вывода отрезка
        Color currentBorderColor; // текущий цвет отрезка и текущий цвет заливки
        private int currentPenWidth = 1; // текущая толщина пера
        Color currentFillColor = Color.Green;
        

        public Form1()
        {
            InitializeComponent();
        }



        private void pictureBox1_MouseDown(object sender, MouseEventArgs e)
        {
            if (radioButton1.Checked == true)
            {
                xn = e.X;
                yn = e.Y;
            }
            else
            {
                MessageBox.Show("Вы не выбрали алгоритм вывода фигуры!");
            }
        }

        private void pictureBox1_MouseUp(object sender, MouseEventArgs e)
        {
           
            int index, numberNodes;
            double xOutput, yOutput, dx, dy;
            
            Pen myPen = new Pen(currentBorderColor, currentPenWidth);

            Graphics g = Graphics.FromHwnd(pictureBox1.Handle);

            xk = e.X;
            yk = e.Y;
            dx = xk - xn;
            dy = yk - yn;
            numberNodes = 200;
            xOutput = xn;
            yOutput = yn;
            for (index = 1; index <= numberNodes; index++)
            {
                g.DrawRectangle(myPen, (int)xOutput, (int)yOutput, 2, 2);
                xOutput = xOutput + dx / numberNodes;
                yOutput = yOutput + dy / numberNodes;
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            pictureBox1.Image = null;
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

        private void button3_Click(object sender, EventArgs e)
        {
            DialogResult dialogResult = colorDialog1.ShowDialog();

            if (dialogResult == DialogResult.OK && radioButton1.Checked)
            {
                currentBorderColor = colorDialog1.Color;
            }
        }

        private void button2_Click(object sender, EventArgs e)
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

        private void FloodFill(int x1, int y1)
        {
            Color oldPixelColor = myBitmap.GetPixel(x1, y1);
            if ((oldPixelColor.ToArgb() != currentBorderColor.ToArgb())
            && (oldPixelColor.ToArgb() != currentFillColor.ToArgb()))
            {
                myBitmap.SetPixel(x1, y1, currentFillColor);
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

        private void button4_Click(object sender, EventArgs e)
        {
            // Проверяем, удалось ли преобразовать введённое значение в число
            if (int.TryParse(textBox1.Text, out int penWidth))
            {
                // Проверяем, чтобы толщина пера была в разумных пределах
                if (penWidth > 0 && penWidth <= 200) // Ограничим толщину пера до 200
                {
                    // Устанавливаем новую толщину пера
                    currentPenWidth = penWidth;

                    // Показываем MessageBox с подтверждением
                    MessageBox.Show($"Толщина линии изменена на {penWidth}.",
                                    "Успех",
                                    MessageBoxButtons.OK,
                                    MessageBoxIcon.Information);
                }

                else
                {
                    // Показываем MessageBox с ошибкой, если толщина пера вне допустимого диапазона
                    MessageBox.Show("Толщина линии должна быть от 1 до 200.",
                                    "Ошибка",
                                    MessageBoxButtons.OK,
                                    MessageBoxIcon.Error);
                }
            }

            else
            {
                // Показываем MessageBox с ошибкой, если введено некорректное значение
                MessageBox.Show("Введите корректное число!",
                                "Ошибка",
                                MessageBoxButtons.OK,
                                MessageBoxIcon.Error);
            }
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void button5_Click(object sender, EventArgs e)
        {
            DialogResult dialogResult = colorDialog1.ShowDialog();

            // Если пользователь выбрал цвет и нажал OK
            if (dialogResult == DialogResult.OK)
            {
                // Устанавливаем выбранный цвет как текущий цвет заливки
                currentFillColor = colorDialog1.Color;
            }
        }

        private void button6_Click(object sender, EventArgs e)
        {
            
        }
    }
}