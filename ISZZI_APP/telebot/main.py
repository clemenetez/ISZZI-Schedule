from telegram import Update
from telegram.ext import ApplicationBuilder, ContextTypes, CommandHandler, MessageHandler, filters
from dotenv import load_dotenv
from controll_file import moved, deldir
import os

load_dotenv()
PATH = '~/ISZZI_APP/'

async def start(update: Update, context: ContextTypes.DEFAULT_TYPE):
  await context.bot.send_message(chat_id=update.effective_chat.id, text='Hello!')

async def downFile(update: Update, context: ContextTypes.DEFAULT_TYPE):
  if not os.path.exists(PATH+"src"):
    os.mkdir(PATH+"src")
  if "розклад" in update.channel_post.document.file_name:
    file = await context.bot.get_file(update.channel_post.document.file_id) #update.message.document.file_id
    file_name = await file.download_to_drive()
    moved(file_name)
    await context.bot.send_message(chat_id=os.getenv('ADMIN'), text="Файл було встановлено!")

async def clearall(update: Update, context: ContextTypes.DEFAULT_TYPE):
  deldir(PATH)
  await context.bot.send_message(chat_id=os.getenv('ADMIN'), text="Деку було видалено!")

async def changePath(update: Update, context: ContextTypes.DEFAULT_TYPE):
  await context.bot.send_message(chat_id=update.effective_chat.id, text=f"Наразі дека: {PATH}")
  PATH = update.message.text
  await context.bot.send_message(chat_id=update.effective_chat.id, text=f"Деку було змінено на {PATH}")

if __name__ == '__main__':
  application = ApplicationBuilder().token(os.getenv('TOKEN')).build()
  application.add_handler(MessageHandler(filters.Document.PDF, downFile))
  application.add_handler(CommandHandler('start', start))
  application.add_handler(CommandHandler('clear', clearall))
  application.run_polling()
