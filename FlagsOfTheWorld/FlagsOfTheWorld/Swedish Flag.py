import turtle

def draw_base(height, length, color):
    height = height*10
    length = length*16
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

def draw_cross(height, length, color):
    short_length = 40
    long_length = 50
    cap_length = 20
    longest_length = 90
    x = 0

    turtle.forward(long_length)
    turtle.forward(cap_length)
    turtle.left(180)

    turtle.color(get_color(color))
    turtle.begin_fill()
    

    turtle.forward(cap_length)
    turtle.left(90)
    turtle.forward(short_length)
    turtle.right(90)
    turtle.forward(long_length)
    turtle.left(90)
    
    turtle.forward(cap_length)
    turtle.left(90)
    turtle.forward(long_length)
    turtle.right(90)
    turtle.forward(short_length)
    turtle.left(90)
    turtle.forward(cap_length)

    turtle.left(90)
    turtle.forward(short_length)

    turtle.right(90)
    turtle.forward(longest_length)
    turtle.left(90)
    turtle.forward(cap_length)
    turtle.left(90)
    turtle.forward(longest_length)

    turtle.right(90)
    turtle.forward(short_length)

    turtle.end_fill()

    turtle.left(90)
    turtle.forward(cap_length)
    turtle.forward(long_length)
           
def draw_rectangle(height, length, color):
    height = height* 10
    length = length* 16
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
        color_code = ('#006BA8')

    if color_wanted == 'yellow':
        color_code = ('#FECD01')

    return color_code

turtle.left(90)
draw_base(10, 10, "blue")
draw_cross(10, 10, 'yellow')
draw_rectangle(10, 10, "black")
