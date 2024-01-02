import os

def rotat(path):
  with open(path+'site/index.html', 'w') as file:
    file.write("<title>doc</title>\n")
    for i in range(6):
      file.write(f'<img src="{path+f"src/schedule{i+1}.jpg"}">\n')