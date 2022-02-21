import turtle

def draw_stripes(height, length, color):
    height = (height*2)/9
    length = length*3
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

def draw_square(height, color):
    height = (height*2)/9
    x = 0

    turtle.color(get_color(color))
    turtle.begin_fill()
    
    turtle.right(90)

    while x < 4:
        turtle.forward(height*5)
        turtle.right(90)
        x = x + 1

    turtle.end_fill()

def draw_cross(height, color):
    height = (height*2)/9
    long_height = (height*2)
    x = 0

    turtle.forward(long_height)
    turtle.right(180)
    
    turtle.color(get_color(color))
    turtle.begin_fill()

    while x < 4:
        turtle.left(90)
        turtle.forward(long_height)
        turtle.right(90)
        turtle.forward(long_height)
        turtle.left(90)
        turtle.forward(height)
        x = x + 1

    turtle.end_fill()

    turtle.forward(long_height)
        
def draw_rectangle(height, length, color):
    height = height*2
    length = length*3
    x = 0

    turtle.left(90)

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
        color_code = ('#0D5EAF')

    return color_code

turtle.left(90)
draw_stripes(100, 100, "blue")
draw_stripes(100, 100, "white")
draw_stripes(100, 100, "blue")
draw_stripes(100, 100, "white")
draw_stripes(100, 100, "blue")
draw_stripes(100, 100, "white")
draw_stripes(100, 100, "blue")
draw_stripes(100, 100, "white")
draw_stripes(100, 100, "blue")
draw_square(100, 'blue')
draw_cross(100, 'white')
draw_rectangle(100, 100, 'black')


