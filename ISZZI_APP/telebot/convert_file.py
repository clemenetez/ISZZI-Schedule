from pdf2image import convert_from_path

def convert_pdf_to_jpg(path, output):
  pdf_images = convert_from_path(path)
  for idx in range(len(pdf_images)):
    pdf_images[idx].save(output+'.png', 'PNG')

convert_pdf_to_jpg(str('~/ISZZI_APP/')+"telebot/"+'a.pdf', str('~/ISZZI_APP/')+f'src/a')
