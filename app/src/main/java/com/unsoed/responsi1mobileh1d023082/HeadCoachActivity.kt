package com.unsoed.responsi1mobileh1d023082

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.unsoed.responsi1mobileh1d023082.databinding.ActivityHeadCoachBinding
import com.unsoed.responsi1mobileh1d023082.viewmodel.TeamViewModel

class HeadCoachActivity : ComponentActivity() {
    private lateinit var binding: ActivityHeadCoachBinding
    private lateinit var viewModel: TeamViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeadCoachBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[TeamViewModel::class.java]

        binding.layoutCoachInfo.visibility = View.GONE

        val teamId = 115
        viewModel.loadTeam(teamId, "ac7820d97448430bbe169c962a3b842c")

        viewModel.teamData.observe(this) { team ->
            val coach = team.coach
            binding.tvCoachName.text = coach.name
            binding.tvCoachBirth.text = coach.dateOfBirth ?: "-"
            binding.tvCoachNationality.text = coach.nationality

            Glide.with(this)
                .load(R.drawable.coach)
                .into(binding.imgCoach)

            binding.layoutCoachInfo.visibility = View.VISIBLE
        }

        viewModel.error.observe(this) { error ->
            binding.tvCoachName.text = error
        }
    }
}