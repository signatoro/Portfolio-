import turtle

def draw_base(height, length, color):
    height = height*18
    length = length*25
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
    long_length = 70
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
    norm_length = 80
    long_length = 150
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
    turtle.forward(100)
           
def draw_rectangle(height, length, color):
    height = height* 18
    length = length* 25
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
        color_code = ('#003897')

    if color_wanted == 'red':
        color_code = ('#D72828')

    return color_code

turtle.left(90)

draw_base(10, 10, "blue")
draw_white_cross(10, 10, 'white')
draw_red_cross (10, 10, 'red')
draw_rectangle(10, 10, "black")
