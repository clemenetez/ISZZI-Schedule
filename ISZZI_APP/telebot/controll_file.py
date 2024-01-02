import os
from convert_file import convert_pdf_to_jpg
from edit import main
from tosite import rotat

def moved(fileName:str, path:str):
  convert_pdf_to_jpg(str(path)+"telebot/"+str(fileName), str(path)+f'src/{fileName}')
  main(fileName, 'c25')
  os.system(f'rm {path}src/{fileName}.png')
  os.system(f"rm {path}telebot/{fileName}")
  rotat(path)

def deldir(path:str):
  os.system(f'rm -r {path}src')