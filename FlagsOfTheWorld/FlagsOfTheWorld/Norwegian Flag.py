import turtle

def draw_base(height, length, color):
    height = height*16
    length = length*22
    x = 0

    turtle.color(get_color(color))
    turtle.begin_fill()

    while x < 2:
        turtle.forward(height)
        turtle.right(90)
        turtle.forward(length)
        turtle.right(90)
        x = x + 1
    
    turtle.end_fill()

    turtle.forward(height)
    turtle.right(90)

def draw_white_cross(height, length, color):
    short_length = 40
    long_length = 60
    x = 0

    turtle.forward(long_length)
    turtle.forward(short_length)
    turtle.left(180)

    turtle.color(get_color(color))
    turtle.begin_fill()
    

    while x < 3:
        turtle.forward(short_length)
        turtle.left(90)
        turtle.forward(long_length)
        turtle.right(90)
        turtle.forward(long_length)
        turtle.left(90)
        x = x + 1

    turtle.right(90)
    turtle.forward(long_length)
    turtle.left(90)
    turtle.forward(short_length)


    turtle.left(90)
    turtle.forward(long_length*2)
    turtle.right(90)
    turtle.forward(long_length)

    turtle.end_fill()
    
def draw_red_cross(height, length, color):
    short_length = 20
    norm_length = 70
    long_length = 130
    x = 0

    turtle.left(90)
    turtle.forward(10)
    turtle.speed(5)

    turtle.color(get_color(color))
    turtle.begin_fill()
    
    while x < 2:
        turtle.forward(short_length)
        turtle.left(90)
        turtle.forward(norm_length)
        turtle.right(90)
        turtle.forward(norm_length)
        turtle.left(90)
        x = x + 1

    turtle.forward(short_length)
    turtle.left(90)
    turtle.forward(norm_length)
    turtle.right(90)

    turtle.forward(long_length)
    turtle.left(90)
    turtle.forward(short_length)
    turtle.left(90)
    turtle.forward(long_length)
    turtle.right(90)
    turtle.forward(norm_length)

    turtle.end_fill()

    turtle.left(90)
    turtle.forward(90)
           
def draw_rectangle(height, length, color):
    height = height* 16
    length = length* 22
    x = 0

    turtle.color(get_color(color))
    turtle.left(90)

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
        color_code = ('#002868')

    if color_wanted == 'red':
        color_code = ('#EF2B2D')

    return color_code

turtle.left(90)
turtle.speed(1000)
draw_base(10, 10, "red")
draw_white_cross(10, 10, 'white')
draw_red_cross (10, 10, 'blue')
draw_rectangle(10, 10, "black")
