package io.github.amirisback.gamedev

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 * Created by faisalamircs on 24/12/2023
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    protected val binding: VB by lazy {
        setupViewBinding()
    }

    private var activityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        setupActivityResultExt(result)
    }

    abstract fun setupViewBinding(): VB

    open fun setupActivityResultExt(result: ActivityResult) {}

    open fun startActivityResultExt(intent: Intent) {
        activityResult.launch(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

}