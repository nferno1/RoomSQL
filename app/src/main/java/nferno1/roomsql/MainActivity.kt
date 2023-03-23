package nferno1.roomsql

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import nferno1.roomsql.databinding.ActivityMainBinding

@Suppress("DEPRECATION", "UNCHECKED_CAST")
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
   private val viewModel: MainViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val userDao = (application as App).db.userDao()
                return MainViewModel(userDao) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addBtn.setOnClickListener { viewModel.onAddBtn() }
        binding.updateBtn.setOnClickListener { viewModel.onUpdateBtn() }
        binding.deleteBtn.setOnClickListener { viewModel.onDeleteBtn() }

        lifecycleScope.launchWhenCreated {
            viewModel.allUsers
                .collect { users: List<UserWithAddress> ->
                    binding.textView
                        .text = users.joinToString(
                        separator = "\r\n"
                    )
                }
        }

    }
}