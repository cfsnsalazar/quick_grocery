import com.example.quickgrocery.common.BaseViewModelTest
import com.example.quickgrocery.common.di.ApplicationComponent
import com.example.quickgrocery.common.di.ApplicationModule
import com.example.quickgrocery.common.viewModel.BaseViewModel
import com.example.quickgrocery.meals.activity.MealsActivityViewModelTest
import dagger.Component
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        (ApplicationModule::class)
    ]
)

@ExperimentalCoroutinesApi
interface TestApplicationComponent: ApplicationComponent {
    @FlowPreview
    fun inject(viewModelTest: MealsActivityViewModelTest)
    fun inject(viewModelTest: BaseViewModelTest)
}