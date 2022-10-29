package kg.geektech.barashki.adapter

import android.annotation.SuppressLint
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.barashki.R
import kg.geektech.barashki.databinding.ItemSelectedGalleryBinding

class SelectedImageAdapter : RecyclerView.Adapter<SelectedImageAdapter.ImageHolder>() {

    //Переменная
    private val imageList = arrayListOf<Uri>()

    //Холдер
    class ImageHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = ItemSelectedGalleryBinding.bind(item)
        fun bind(mainImage: Uri) = with(binding) {
            imageSelectedRecycler.setImageURI(mainImage) //Вставляем изображение
        }
    }

    //Стандарт адаптер
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_selected_gallery, parent, false)
        return ImageHolder(view)
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        holder.bind(imageList[position])
    }

    override fun getItemCount() = imageList.size

    //Метод
    @SuppressLint("NotifyDataSetChanged")
    fun addImage(mainImage: ArrayList<Uri>) {
        this.imageList.addAll(mainImage)
        notifyDataSetChanged()
    }
}