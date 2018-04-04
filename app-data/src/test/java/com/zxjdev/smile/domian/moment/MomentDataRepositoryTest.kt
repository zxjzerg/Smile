package com.zxjdev.smile.domian.moment

import com.zxjdev.smile.data.moment.MomentDataRepository
import com.zxjdev.smile.data.moment.datasource.MomentCloudDataSource
import com.zxjdev.smile.data.moment.entity.MomentMapper
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class MomentDataRepositoryTest {

    private lateinit var momentDataRepository: MomentDataRepository
    @Mock private lateinit var momentCloudDataSource: MomentCloudDataSource
    @Mock private lateinit var momentMapper: MomentMapper

    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)
        momentDataRepository = MomentDataRepository(momentCloudDataSource, momentMapper)
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.newThread() }
    }

    @Test
    fun testAddMoment() {
        val content = "123"
        momentDataRepository.addMoment(content).test()

        verify<MomentCloudDataSource>(momentCloudDataSource).addMoment(content)
    }

    @Test
    fun queryMomentList() {
        momentDataRepository.queryMomentList().test()

        verify<MomentCloudDataSource>(momentCloudDataSource).getMomentList()
    }
}
