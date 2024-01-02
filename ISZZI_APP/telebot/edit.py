from PIL import Image

# (190, 990, 675, 1350) понеділок с1
# (190, 140, 675, 500) понеділок с3
# (190, 565, 675, 925) понеділок с2
# (190, 1412, 675, 1772) понеділок с0
# (190, 2055, 675, 2270) понеділок с9
CCURSE = {
  'c25': (190, 855, 675, 925),
  'c24': (190, 784, 675, 855),
  'c23': (190, 711, 675, 781),
  'c22': (190, 638, 675, 708),
  'c21': (190, 565, 675, 635),

  'c35': (190, 432, 675, 502),
  'c34': (190, 359, 675, 429),
  'c33': (190, 286, 675, 356),
  'c32': (190, 213, 675, 283),
  'c31': (190, 140, 675, 210),

  'c15': (190, 1278, 675, 1350),
  'c14': (190, 1207, 675, 1279),
  'c13': (190, 1134, 675, 1206),
  'c12': (190, 1061, 675, 1133),
  'c11': (190, 990, 675, 1060),

  'c05': (190, 1700, 675, 1770),
  'c04': (190, 1630, 675, 1699),
  'c03': (190, 1555, 675, 1630),
  'c02': (190, 1485, 675, 1553),
  'c01': (190, 1412, 675, 1480),


  'c93': (190, 2197, 675, 2270),
  'c92': (190, 2127, 675, 2194),
  'c91': (190, 2055, 675, 2120)
}
PATH = '~/ISZZI_APP/'
FILE = None
FILE_SIZE = None

def upload_file(file_path):
  global FILE, FILE_SIZE
  FILE = Image.open(file_path)
  FILE_SIZE = FILE.size

def edit(size, namedapp=None):
  global FILE
  if len(size) == 4 and all(isinstance(coord, int) for coord in size):
    crop_left, crop_top, crop_right, crop_bottom = size
    if crop_left < crop_right and crop_top < crop_bottom:
      cropped = FILE.crop(size)
      cropped.save(f"{PATH}src/schedule{namedapp+1 if namedapp != None else 0}.jpg")
    else:
      print("The specified region is empty")
  else:
    print("Wrong tuple")

def main(file_name, PATH):
  upload_file(PATH + f'src/{file_name}.png')
  rot = 488

  for group, coord in CCURSE.items():
    edit(coord, PATH, f'{group}1')
    for i in range(1, 6):
      edit(coord := tuple(x + rot if i in (0, 2) else x for i, x in enumerate(coord)), PATH, f'{group}{i+1}')

# для заповнення груп, ріже полосками по групам
def foo():
  course, group = 0, 1
  ptrtuple = (190, 1280-73, 675, 1350-73)
  for _ in range(5):
    print(f"C{course}{group} - ", ptrtuple := tuple(x + 73 if i in (1, 3) else x for i, x in enumerate(ptrtuple)))
    group += 1

#upload_file(PATH+'src/1.png')
#edit(CCURSE['c21'])
# foo()
