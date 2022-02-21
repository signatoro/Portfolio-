import turtle

def draw_base(height, length, color):
    height = height*22
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

def draw_cross(color):
    side_length = 56
    cap_length = 48
    flag_dis_length = 30
    x = 0

    turtle.forward(flag_dis_length + side_length + cap_length)
    turtle.right(90)
    turtle.forward(flag_dis_length)
    turtle.right(90)

    turtle.color(get_color(color))
    turtle.begin_fill()

    while x < 4:
        z = 0 
        turtle.forward(cap_length)
        turtle.left(90)

        while z < 2:
            turtle.forward(side_length)
            turtle.right(90)
            z = z+1
        turtle.left(180)
        x = x + 1
        
    turtle.end_fill()

    turtle.color(get_color('red'))
    turtle.right(90)
    turtle.forward(flag_dis_length)
    turtle.left(90)
    turtle.forward(flag_dis_length + side_length + cap_length)


def draw_rectangle(height, length, color):
    height = height* 22
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

    if color_wanted == 'red':
        color_code = ('#FF0000')

    return color_code

turtle.left(90)
draw_base(10, 10, "red")
draw_cross('white')
draw_rectangle(10, 10, "black")
