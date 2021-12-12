package talk.push.faceter.feature.fragments.choosing


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import kotlinx.android.synthetic.main.fragment_choosing_actions.*
import talk.push.faceter.R

class ChoosingActionsFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_choosing_actions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_call.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_choosingActionsFragment_to_settingsFragment)
        }

    }

}