package dduw.com.mobile.umc_2week_mission
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import dduw.com.mobile.umc_2week_mission.databinding.ActivityMainBinding
import dduw.com.mobile.umc_2week_mission.databinding.FragmentBagBinding

class BagFragment : Fragment() {
    private lateinit var binding: FragmentBagBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBagBinding.inflate(inflater, container, false)
        return binding.root
    }
}
