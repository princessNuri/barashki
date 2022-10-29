package kg.geektech.barashki.adapter

import android.annotation.SuppressLint
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.View.*
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.barashki.R
import kg.geektech.barashki.databinding.ItemListBinding

class PicAdapter(private var listener: Listener) :
    RecyclerView.Adapter<PicAdapter.AdapterHolder>() {

    private val imageList = arrayListOf<Uri>()
 //Стандарт адаптера
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return AdapterHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterHolder, position: Int) {
        holder.bind(imageList[position], listener)
    }

    override fun getItemCount() = imageList.size


    class AdapterHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = ItemListBinding.bind(item)

        fun bind(mainImage: Uri, listener: Listener) = with(binding) {
            image.setImageURI(mainImage) //Тут устанавливаем изображение
            imageShadow.visibility = INVISIBLE //Чтобы тени не было сразу
            itemView.setOnClickListener { //Слушатель на изображенеи
                if (!imageShadow.isVisible) { // Проверка то что тени выключены
                    listener.onClick(mainImage) // Тут идет нажатие на изображение
                    imageShadow.visibility = VISIBLE // Установка невидимости
                } else  {
                    listener.deleteClick(mainImage)
                    imageShadow.visibility = INVISIBLE // Установка видимости
                }
            }
        }
    }

    //метод
    @SuppressLint("NotifyDataSetChanged")
    fun addImage(image: Uri) {
        this.imageList.addAll(listOf(image))
        notifyDataSetChanged()
    }

    //Интерфейс
    interface Listener {
        fun onClick(mainImage: Uri)
        fun deleteClick(mainImage: Uri)
    }
}