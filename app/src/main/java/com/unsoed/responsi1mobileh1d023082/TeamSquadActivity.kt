package com.unsoed.responsi1mobileh1d023082

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.unsoed.responsi1mobileh1d023082.databinding.ActivityTeamSquadBinding
import com.unsoed.responsi1mobileh1d023082.ui.adapter.SquadAdapter
import com.unsoed.responsi1mobileh1d023082.ui.fragment.PlayerFragment
import com.unsoed.responsi1mobileh1d023082.viewmodel.TeamViewModel

class TeamSquadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTeamSquadBinding
    private lateinit var viewModel: TeamViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamSquadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[TeamViewModel::class.java]

        val teamId = 115
        viewModel.loadTeam(teamId, "ac7820d97448430bbe169c962a3b842c")

        binding.rvSquad.layoutManager = LinearLayoutManager(this)

        viewModel.teamData.observe(this) { team ->
            val adapter = SquadAdapter(team.squad) { player ->
                PlayerFragment(
                    player.name,
                    player.dateOfBirth ?: "-",
                    player.nationality,
                    player.position ?: "-"
                ).show(
                    supportFragmentManager,
                    PlayerFragment::class.java.simpleName
                )
            }
            binding.rvSquad.adapter = adapter
        }

        viewModel.error.observe(this) { error ->
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
        }
    }
}