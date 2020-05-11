import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.quickgrocery.common.ThemeDataSource
import com.example.quickgrocery.common.di.ApplicationModule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.mockito.Mockito

@ExperimentalCoroutinesApi
class TestApplicationModule(app: Application) : ApplicationModule(app) {

    override fun provideContext(): Context {
        return Mockito.mock(Context::class.java)
    }

    override fun provideSharedPreferences(context: Context): SharedPreferences {
        return Mockito.mock(SharedPreferences::class.java)
    }

    override fun provideThemeDataSource(sharedPreferences: SharedPreferences): ThemeDataSource {
        return Mockito.mock(ThemeDataSource::class.java)
    }
}
