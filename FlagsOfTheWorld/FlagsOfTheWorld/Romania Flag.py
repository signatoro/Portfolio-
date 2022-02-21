import turtle

def draw_stripes(height, length, color):
    height = height * 20
    length = length * 30
    x = 0 

    turtle.color(get_color(color))
    turtle.begin_fill()

    while x < 2:
        turtle.forward(height)
        turtle.right(90)
        turtle.forward(length/3)
        turtle.right(90)
        x = x + 1
    turtle.end_fill()

    turtle.left(90)
    turtle.backward(length/3)
    turtle.right(90)

def draw_rectangle(height, length, color):
    height = height * 20
    length = length * 30
    x = 0

    turtle.color(get_color(color))

    while x < 2:
        turtle.forward(height)
        turtle.left(90)
        turtle.forward(length)
        turtle.left(90)
        x = x + 1

def get_color(color_wanted):

    if color_wanted == 'white':
        color_code = ("#FFFFFF")
    
    if color_wanted == 'black':
        color_code = ('#000000')

    if color_wanted == 'blue':
        color_code = ('#002B7F')
        
    if color_wanted == 'yellow':
        color_code = ('#FCD116')

    if color_wanted == 'red':
        color_code = ('#CE1126')

    return color_code

turtle.left(90)
draw_stripes(10, 10, 'blue')
draw_stripes(10, 10, 'yellow')
draw_stripes(10, 10, 'red')
draw_rectangle(10, 10, 'black')
