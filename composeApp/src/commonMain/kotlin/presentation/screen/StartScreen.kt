package presentation.screen

/*

class StartScreen : Screen {
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = getScreenModel<HomeViewModel>()
        val loginUserUiState by viewModel.uiState.collectAsState()

        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(title = { Text("home") })
            },
        ) { paddingValues ->
            Column(
                modifier = Modifier.padding(paddingValues)
            ) {
                Row {
                    LazyColumn {
                        stickyHeader {
                            Row (){
                                Text(text = "List", fontSize = 20.sp, modifier = Modifier.align(Alignment.CenterVertically))
                            }
                        }
                            items(1_000) {

                            Row (
                                modifier = Modifier.background(Color.Blue),
                            ){
                                defaultCardView()
                               // Checkbox(checked = true, onCheckedChange = {})
                               // Text(text = "Alexis", fontSize = 20.sp, modifier = Modifier.align(Alignment.CenterVertically))
                            }
                        }
                    }
                }
            }
        }
    }
}*/
