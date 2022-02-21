import turtle

def draw_stripes(height, length, color):
    height = height * 10
    length = (length * 20)
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
    height = height * 10
    length = length * 20
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

    if color_wanted == 'green':
        color_code = ('#169B62')
        
    if color_wanted == 'orange':
        color_code = ("#FF883E")

    return color_code


turtle.left(90)
draw_stripes(20, 20, 'orange')
draw_stripes(20, 20, 'white')
draw_stripes(20, 20, 'green')
draw_rectangle(20, 20, 'black')



    
    
