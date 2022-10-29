package kg.geektech.barashki.activity

import android.net.Uri
import android.view.LayoutInflater
import androidx.recyclerview.widget.GridLayoutManager
import kg.geektech.barashki.adapter.SelectedImageAdapter
import kg.geektech.barashki.base.BaseActivity
import kg.geektech.barashki.databinding.ActivitySelectedImageBinding

class SelectedImageActivity : BaseActivity<ActivitySelectedImageBinding>() {

    private val adapter = SelectedImageAdapter()

    override fun inflateVB(inflater: LayoutInflater): ActivitySelectedImageBinding {
        return ActivitySelectedImageBinding.inflate(inflater)
    }

    override fun initListener() {
        val uri: ArrayList<Uri>? = intent.getParcelableArrayListExtra(MainActivity.KEY_IMG)
        if (uri != null) {
            adapter.addImage(uri)
        }
    }

    override fun initView() {
        binding.selectedRecycler.layoutManager = GridLayoutManager(this@SelectedImageActivity, 3)
        binding.selectedRecycler.adapter = adapter
    }
}