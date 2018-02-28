package com.zxjdev.smile.domian.moment

import com.zxjdev.smile.data.moment.MomentDataRepository
import com.zxjdev.smile.data.moment.entity.MomentEntity
import com.zxjdev.smile.data.moment.entity.MomentMapper
import com.zxjdev.smile.data.moment.datasource.MomentCloudDataSource

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

import rx.Observable

import org.mockito.BDDMockito.given
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class MomentDataRepositoryTest {

    private var momentDataRepository: MomentDataRepository? = null
    @Mock
    internal var momentCloudDataSource: MomentCloudDataSource? = null
    @Mock
    internal var momentMapper: MomentMapper? = null

    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)
        momentDataRepository = MomentDataRepository(momentCloudDataSource, momentMapper)
    }

    @Test
    fun testAddMoment() {
        val content = "123"
        momentDataRepository!!.addMoment(content)

        verify<MomentCloudDataSource>(momentCloudDataSource).addMoment(content)
    }

    @Test
    fun queryMomentList() {
        val momentList = mock(List<*>::class.java)
        given<Observable<List<MomentEntity>>>(momentCloudDataSource!!.momentList).willReturn(Observable.just(momentList))
        momentDataRepository!!.queryMomentList()

        verify<MomentCloudDataSource>(momentCloudDataSource).momentList
    }

    @Test
    fun testQueryMoment() {
        val momentId = "123"
        momentDataRepository!!.queryMoment(momentId)

        verify<Observable<Void>>(momentCloudDataSource!!.addMoment(momentId))
    }
}
